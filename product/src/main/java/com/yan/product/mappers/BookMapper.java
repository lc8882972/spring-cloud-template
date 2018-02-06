package com.yan.product.mappers;

import com.yan.product.entities.Book;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface BookMapper {

    @Select("SELECT * FROM book")
    @Results({
            @Result(property = "id",  column = "id"),
            @Result(property = "name", column = "name")
    })
    List<Book> getAll();

    @Select("SELECT * FROM book WHERE id = #{id}")
    @Results({
            @Result(property = "id",  column = "id"),
            @Result(property = "name", column = "name")
    })
    Book getOne(Long id);

    @Insert("INSERT INTO users(name) VALUES(#{name})")
    void insert(Book user);

    @Update("UPDATE users SET name=#{name} WHERE id =#{id}")
    void update(Book user);

    @Delete("DELETE FROM users WHERE id =#{id}")
    void delete(Long id);

}
