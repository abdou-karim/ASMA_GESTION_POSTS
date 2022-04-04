package sn.gestion.post.service.imp;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import sn.gestion.post.dto.TransactionDto;
import sn.gestion.post.exception.EntityNotFoundException;
import sn.gestion.post.exception.ErrorCodes;
import sn.gestion.post.exception.InvalidEntityException;
import sn.gestion.post.model.Transaction;
import sn.gestion.post.repository.TransactionRepository;
import sn.gestion.post.service.TransactionService;
import sn.gestion.post.validator.TransactionValidator;

import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Service
@AllArgsConstructor
public class TransactionServiceImpl implements TransactionService {

    private TransactionRepository transactionRepository;

    @Override
    public List<TransactionDto> findAll() {
        return transactionRepository.findAll().stream().map(TransactionDto::fromEntity).collect(Collectors.toList());
    }

    @Override
    public TransactionDto save(TransactionDto transactionDto) throws Exception {

        validation(transactionDto);
        return TransactionDto.fromEntity(transactionRepository.save(TransactionDto.toEntity(transactionDto)));
    }

    @Override
    public TransactionDto findById(Long id) {
        if (id == null) {
            log.error("Admin id is null");
            return null;
        }
        return transactionRepository.findById(id).map(TransactionDto::fromEntity).orElseThrow(() ->
                new EntityNotFoundException(
                        "Aucun Transaction avec l'ID = " + id + " ne se trouve dans la BDD",
                        ErrorCodes.Transaction_NOT_FOUND)
        );
    }

    @Override
    public TransactionDto put(TransactionDto transactionDto, Long id) throws Exception {
        return null;
    }

    @Override
    public void delete(Long id) {
        if (id==null) {
            log.error("Transaction id is null");
        }
        Transaction transaction = transactionRepository.findByIdAndArchiveFalse(id).orElseThrow(() ->
                new EntityNotFoundException(
                        "Aucun Transaction avec l'ID = " + id + " ne se trouve dans la BDD",
                        ErrorCodes.Transaction_NOT_FOUND));
        transaction.setArchive(true);
        transactionRepository.flush();
    }

    private  void validation(TransactionDto transactionDto) {
        List<String> errors = TransactionValidator.ValidateTrans(transactionDto);
        if(!errors.isEmpty()){
            throw new InvalidEntityException("Erreurs!!!", ErrorCodes.Transaction_NOT_VALID, errors);
        }
    }
}
