package com.burgas.springbrandcars.mapper;

import com.burgas.springbrandcars.model.Category;
import org.jetbrains.annotations.NotNull;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class CategoryRowMapper implements RowMapper<Category> {

    @Override
    public Category mapRow(@NotNull ResultSet resultSet, int rowNum) throws SQLException {
        return new Category(
                resultSet.getInt("id"),
                resultSet.getString("name"),
                resultSet.getString("image"),
                resultSet.getString("description")
        );
    }
}
