package com.example.helloworld.database;

import java.util.List;

import org.skife.jdbi.v2.sqlobject.Bind;
import org.skife.jdbi.v2.sqlobject.BindBean;
import org.skife.jdbi.v2.sqlobject.SqlQuery;
import org.skife.jdbi.v2.sqlobject.SqlUpdate;
import org.skife.jdbi.v2.sqlobject.customizers.RegisterMapperFactory;
import org.skife.jdbi.v2.tweak.BeanMapperFactory;

@RegisterMapperFactory(BeanMapperFactory.class)
public interface ProductDAO {
	@SqlUpdate("create table if not exists Products (id int default not null auto_increment primary key, name varchar(255));")
	void createProductTable();

	@SqlUpdate("insert into Products (name) values (:name)")
	void insert(@BindBean Product product);

	@SqlQuery("select * from Products")
	List<Product> getAll();

	@SqlQuery("select * from Products where id = :id")
	Product findById(@Bind("id") int id);

	@SqlUpdate("update Products set name: u.name where id = :id")
	void update(@BindBean("u") Product product, @Bind("id") int id);

	@SqlUpdate("delete from Products where id = :it")
	void deleteById(@Bind int id);

}
