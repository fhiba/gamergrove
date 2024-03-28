package ar.edu.itba.paw.persistance;

import ar.edu.itba.paw.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import javax.sql.DataSource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Repository
public class UserDaoJdbc implements UserDao{

    private static final RowMapper<User> ROW_MAPPER = (rs, rowNum) -> new User(rs.getString("username"),rs.getLong("id"));
    private final JdbcTemplate jdbcTemplate;
    private final SimpleJdbcInsert jdbcInsert;
    @Autowired
    public UserDaoJdbc(final DataSource ds){
        jdbcTemplate = new JdbcTemplate(ds);
        jdbcTemplate.execute("CREATE TABLE IF NOT EXISTS users( " +
                "id SERIAL PRIMARY KEY," +
                "username VARCHAR(255) NOT NULL UNIQUE" +
                ")");
        jdbcInsert = new SimpleJdbcInsert(ds).usingGeneratedKeyColumns("id").withTableName("users");
    }

    @Override
    public Optional<User> findById(long id) {
        final List<User> list = jdbcTemplate.query("SELECT * FROM users WHERE id = ?",new Object[]{id},ROW_MAPPER);
        return list.stream().findFirst();
    }

    @Override
    public User create(final String username) {
        final Map<String,Object> userData = new HashMap<>();
        userData.put("username",username);
        final Number id = jdbcInsert.executeAndReturnKey(userData);
        return new User(username,id.longValue());
    }
}
