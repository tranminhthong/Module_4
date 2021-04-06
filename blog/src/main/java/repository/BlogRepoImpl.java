package repository;

import entities.Blog;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import java.util.List;
@Repository
@Transactional
public class BlogRepoImpl implements IBlogRepo {
    @PersistenceContext
    EntityManager em;

    @Override
    public void createNewBlog(Blog blog) {
        em.persist(blog);
    }

    @Override
    public List<Blog> findAll() {
        TypedQuery<Blog> query = em.createQuery("select b from Blog b",Blog.class);
        return query.getResultList();
    }

    @Override
    public Blog viewBlog(int id) {
        TypedQuery<Blog> query = em.createQuery("select b from Blog b where b.id=:id",Blog.class).setParameter("id",id);
        return query.getSingleResult();
    }

    @Override
    public void updateBlog(Blog newBlog) {
        Query query = em.createQuery("update Blog set content=:content, summary=:summary where id=:id");
        query.setParameter("content", newBlog.getContent());
        query.setParameter("summary", newBlog.getSummary());
        query.setParameter("id", newBlog.getId());
        query.executeUpdate();
    }

    @Override
    public void deleteBlog(int id) {
        Query query = em.createQuery("delete from Blog where id=:id");
        query.setParameter("id",id);
        query.executeUpdate();
    }
}
