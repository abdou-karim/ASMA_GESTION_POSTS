package sn.gestion.post.validator;


import org.springframework.util.StringUtils;
import sn.gestion.post.dto.TransactionDto;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class TransactionValidator {

    public static List<String> ValidateTrans (TransactionDto transactionDto) {
        return getString(transactionDto == null, transactionDto.getNumeroTransaction(),
                transactionDto.getDateTransaction(),
                transactionDto.getMontant());
    }

    public static List<String> getString(boolean b, String numeroTransaction, LocalDate dateTransaction, String montant)
    {
        List<String> errors = new ArrayList<>();

        if(b)
        {
            errors.add("Veuillez renseigner le numero de transaction");
            errors.add("Veuillez renseigner la date de transaction");
            errors.add("Veuillez renseigner le montant");
            return errors;
        }
        if (!StringUtils.hasLength(numeroTransaction))
        {
            errors.add("Veuillez renseigner le numero de transaction");
        }
        if (!StringUtils.hasLength(montant))
        {
            errors.add("Veuillez renseigner le montant");
        }
        if (dateTransaction == null) {
            errors.add("Veuillez renseigner la date de naissance'");
        }
        return errors;
    }
}
