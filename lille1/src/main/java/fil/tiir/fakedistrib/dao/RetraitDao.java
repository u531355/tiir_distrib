package fil.tiir.fakedistrib.dao;

import java.util.List;

import fil.tiir.fakedistrib.entity.Retrait;

public interface RetraitDao {
	List<Retrait> getAll();
	void insert(Retrait r);
}
