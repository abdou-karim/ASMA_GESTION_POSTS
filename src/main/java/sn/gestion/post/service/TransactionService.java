package sn.gestion.post.service;

import sn.gestion.post.dto.TransactionDto;

import java.util.List;

public interface TransactionService  {

    List<TransactionDto> findAll();

    TransactionDto save(TransactionDto transactionDto) throws Exception;

    TransactionDto findById(Long id);

    TransactionDto put (TransactionDto transactionDto, Long id)  throws Exception;

    void delete(Long id);
}
