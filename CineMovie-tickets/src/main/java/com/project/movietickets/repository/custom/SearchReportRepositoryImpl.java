package com.project.movietickets.repository.custom;

import com.project.movietickets.entity.TicketEntity;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

@Repository
@Log4j2
public class SearchReportRepositoryImpl implements SearchReportRepository {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<TicketEntity> searchTicket(String startDate, String endDate, String category) {

        StringBuilder sqlBuilder = new StringBuilder("select tickets.* from tickets\n" +
                "inner join room_movie_schedules\n" +
                "on tickets.room_movie_schedule_id = room_movie_schedules.id\n" +
                "inner join movies\n" +
                "on room_movie_schedules.movie_id = movies.id\n" +
                "where 1=1\n");

        if (category != null && !category.equals("ALL")){
            sqlBuilder.append("and movies.category = '" + category + "'\n");
        }

        if (startDate != null && endDate != null && !startDate.isBlank() && !endDate.isBlank()){
            sqlBuilder.append("and tickets.date between '" +
                    startDate +
                    "' and '" +
                    endDate +
                    "'");
        }

        log.info(sqlBuilder.toString());

        Query query = entityManager.createNativeQuery(sqlBuilder.toString(), TicketEntity.class);

        return query.getResultList();
    }
}
