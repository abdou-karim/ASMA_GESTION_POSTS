package sn.gestion.post.controller;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.RestController;
import sn.gestion.post.controller.Api.TransactionApi;
import sn.gestion.post.dto.TransactionDto;
import sn.gestion.post.service.TransactionService;

import java.util.List;

@RestController
@AllArgsConstructor
public class TransactionController implements TransactionApi {

    private TransactionService transactionService;
    @Override
    public List<TransactionDto> findAll() {
        return transactionService.findAll();
    }

    @Override
    public TransactionDto save(TransactionDto transactionDto) throws Exception {
        return transactionService.save(transactionDto);
    }

    @Override
    public TransactionDto findById(Long id) {
        return transactionService.findById(id);
    }

    @Override
    public void delete(Long id) {
       transactionService.delete(id);
    }
}
