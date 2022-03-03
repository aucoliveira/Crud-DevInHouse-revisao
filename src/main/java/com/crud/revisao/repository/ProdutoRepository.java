package com.crud.revisao.repository;

import com.crud.revisao.model.Produto;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface ProdutoRepository extends CrudRepository<Produto,Long> {

}
