package com.dynamicapp.dynamicblogapp.repositories;

import com.dynamicapp.dynamicblogapp.models.BlogModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface BlogsRepository extends JpaRepository<BlogModel,Long> {
    @Override
    List<BlogModel> findAll();

    List<BlogModel> findByBlogauthor(int authorid);

    List<BlogModel> findByBlogtitle(String title);

    List<BlogModel> findByBlogid(int blogid);

    List<BlogModel> findByBlogtitleAndBlogauthor(String title,int authorid);

    List<BlogModel> findByBlogpublishdate(Date publishdate);
}
