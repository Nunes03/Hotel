package br.com.lucasnunes.hotel.services;

import br.com.lucasnunes.hotel.model.CheckIn;
import br.com.lucasnunes.hotel.repositories.CheckInRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class CheckInService {

    @Autowired
    CheckInRepository checkInRepository;

    /**
     * <h1>Busca todos os {@link CheckIn}s.</h1>
     *
     * <p>Busca todos os {@link CheckIn}s
     * do banco através do {@link CheckInRepository#findAll()}.
     * Retorna um {@link ArrayList} de {@link CheckIn}.</p>
     *
     * @return ArrayList {@link CheckIn} - Referente aos
     * {@link CheckIn}s encontrados
     *
     * @see CheckIn
     * @see ArrayList
     * @see CheckInRepository#findAll()
     *
     * @author Lucas Nunes lucasnunes.ln365@gmail.com
     */
    public ArrayList<CheckIn> buscarTodosOsCheckIn(){
        return (ArrayList<CheckIn>) checkInRepository.findAll();
    }

    /**
     * <h1>Busca um {@link CheckIn} pelo id.</h1>
     *
     * <p>Busca um {@link CheckIn} no banco
     * pelo id informado através do
     * {@link CheckInRepository#findById(Object)}.
     * Retorna o {@link CheckIn} correspondente ao id.</p>
     *
     * @return {@link CheckIn} - Referente ao {@link CheckIn} encontrado
     *
     * @see CheckIn
     * @see CheckInRepository#findById(Object)
     *
     * @author Lucas Nunes lucasnunes.ln365@gmail.com
     */
    public CheckIn buscarCheckInPeloId(Integer id){
        return checkInRepository.findById(id).get();
    }

    /**
     * <h1>Insere um {@link CheckIn}.</h1>
     *
     * <p>Recebe um {@link CheckIn} e o
     * insere no banco através do
     * {@link CheckInRepository#save(Object)}.
     * Retorna boolean true caso tenha
     * sido cadastrado.</p>
     *
     * @param checkIn {@link CheckIn} - Referente ao {@link CheckIn}
     * informado
     *
     * @return boolean - true caso tenha sido cadastrado, false caso contrário
     *
     * @see CheckIn
     * @see CheckInRepository#save(Object)
     */
    public boolean inserirCheckIn(CheckIn checkIn){
        try{
            checkInRepository.save(checkIn);
            return true;
        }catch(Exception e){
            System.err.println(e.getMessage());
            return false;
        }
    }

    /**
     * <h1>Deleta um {@link CheckIn}.</h1>
     *
     * <p>Recebe um id e deleta o
     * {@link CheckIn} referente ao id
     * informado através do
     * {@link CheckInRepository#deleteById(Object)}.
     * Retorna true caso tenha dado certo.</p>
     *
     * @param id Integer - Referente ao id informado
     *
     * @return boolean - true caso tenah deletado
     * o {@link CheckIn}, false caso contrário
     *
     * @author Lucas Nunes lucasnunes.ln365@gmail.com
     *
     * @see CheckIn
     * @see CheckInRepository#deleteById(Object)
     */
    public boolean deletarCheckInPeloId(Integer id){
        try{
            checkInRepository.deleteById(id);
            return true;
        }catch (Exception e){
            System.out.println(e.getMessage());
            return false;
        }
    }

    /**
     * <h1>Atualiza um {@link CheckIn}.</h1>
     *
     * <p>Recebe um id e um {@link CheckIn}
     * e atualiza o {@link CheckIn} com o
     * respectivo id através do
     * {@link CheckInRepository#save(Object)}.
     * Retorna true caso tenha dado certo.</p>
     *
     * @param id Integer - Referente ao id informado
     * @param checkIn {@link CheckIn} - Referene ao
     * {@link CheckIn} informado
     *
     * @return boolean - true caso tenha sido atualizado,
     * false caso contrário
     *
     * @see CheckIn
     * @see CheckInRepository#save(Object)
     */
    public boolean atualizaCheckInPeloId(Integer id, CheckIn checkIn){
        try {
            checkIn.setId(id);
            checkInRepository.save(checkIn);
            return true;
        }catch (Exception e){
            System.out.println(e.getMessage());
            return false;
        }
    }

    /**
     * <h1>Procura o {@link CheckIn} por nome do {@link br.com.lucasnunes.hotel.model.Hospede}.</h1>
     *
     * <p>Recebe um nome e procura o {@link CheckIn}
     * do {@link br.com.lucasnunes.hotel.model.Hospede} com esse
     * nome. Faz isso através do {@link CheckInRepository#findByNome(String)}.</p>
     *
     * @param nome String - Referente ao nome informado
     *
     * @return ArrayList {@link CheckIn} - Referente a todos os
     * {@link CheckIn} encontrados com esse nome
     *
     * @see CheckIn
     * @see br.com.lucasnunes.hotel.model.Hospede
     * @see CheckInRepository#findByNome(String) 
     * 
     * @author Lucas Nunes lucasnunes.ln365@gmail.com
     */
    public ArrayList<CheckIn> buscarCheckInPorNomeHospede(String nome){
        return (ArrayList<CheckIn>) checkInRepository.findByNome(nome);
    }

    /**
     * <h1>Procura o {@link CheckIn} por documento do {@link br.com.lucasnunes.hotel.model.Hospede}.</h1>
     *
     * <p>Recebe um documento e procura o {@link CheckIn}
     * do {@link br.com.lucasnunes.hotel.model.Hospede} com esse
     * documento. Faz isso através do {@link CheckInRepository#findByDocumento(Integer)}.</p>
     *
     * @param documento Integer - Referente ao documento informado
     *
     * @return ArrayList {@link CheckIn} - Referente a todos os
     * {@link CheckIn} encontrados com esse documento
     * 
     * @see CheckIn
     * @see br.com.lucasnunes.hotel.model.Hospede
     * @see CheckInRepository#findByDocumento(Integer)  
     * 
     * @author Lucas Nunes lucasnunes.ln365@gmail.com
     */
    public ArrayList<CheckIn> buscarCheckInPorDocumentoHospede(Integer documento){
        return (ArrayList<CheckIn>) checkInRepository.findByDocumento(documento);
    }

    /**
     * <h1>Procura o {@link CheckIn} por telefone do {@link br.com.lucasnunes.hotel.model.Hospede}.</h1>
     *
     * <p>Recebe um telefone e procura o {@link CheckIn}
     * do {@link br.com.lucasnunes.hotel.model.Hospede} com esse
     * nome. Faz isso através do {@link CheckInRepository#findByTelefone(Integer)} .</p>
     *
     * @param telefone Integer - Referente ao telefone informado
     *
     * @return ArrayList {@link CheckIn} - Referente a todos os
     * {@link CheckIn} encontrados com esse telefone
     *
     * @see CheckIn
     * @see br.com.lucasnunes.hotel.model.Hospede
     * @see CheckInRepository#findByTelefone(Integer) 
     *
     * @author Lucas Nunes lucasnunes.ln365@gmail.com
     */
    public ArrayList<CheckIn> buscarCheckInPorTelefoneHospede(Integer telefone){
        return (ArrayList<CheckIn>) checkInRepository.findByTelefone(telefone);
    }
}
