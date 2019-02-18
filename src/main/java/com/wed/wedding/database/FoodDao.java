package com.wed.wedding.database;

import com.wed.wedding.Food;
import com.wed.wedding.FoodType;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import java.sql.*;
import java.util.List;

@Repository
public class FoodDao {

    private JdbcTemplate jdbcTemplate;

    public FoodDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public void createFood(int type, String title, String description) {
        jdbcTemplate.update("insert into menuoptions(type, title, description) values(?, ?, ?)", type, title, description);
    }

    private static class FoodRowMapper implements RowMapper<Food> {
        @Override
        public Food mapRow(ResultSet rs, int i) throws SQLException {
            int typeId = rs.getInt("type_id");
            String type = rs.getString("name");
            String title = rs.getString("title");
            String description = rs.getString("description");
            Food food = new Food(new FoodType(typeId, type), title, description);
            return food;
        }
    }

    public List<Food> listFoods() {
        return jdbcTemplate.query("select menutypes.type_id, menutypes.name, " +
                "menuoptions.title, menuoptions.description " +
                "from menutypes join menuoptions " +
                "on menuoptions.type = menutypes.type_id", new FoodRowMapper());
    }
}
