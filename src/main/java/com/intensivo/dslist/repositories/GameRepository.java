package com.intensivo.dslist.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.intensivo.dslist.entities.Game;
import com.intensivo.dslist.projections.GameMinProjection;

public interface GameRepository extends JpaRepository<Game, Long> {
	
	@Query(nativeQuery = true, value = """
			SELECT tb_games.id, tb_games.title, tb_games.game_year AS "year", tb_games.img_url AS imgUrl,
				tb_games.short_description AS shortDescription, tb_belonging.position
			FROM tb_games
			INNER JOIN tb_belonging ON tb_games.id = tb_belonging.game_id
			WHERE tb_belonging.list_id = :listId
			ORDER BY tb_belonging.position
				""")
	List<GameMinProjection> searchByList(Long listId);

}
