package br.com.lucasnunes.hotel.services;

import br.com.lucasnunes.hotel.model.Hospede;
import br.com.lucasnunes.hotel.repositories.HospedeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;

@Service
public class HospedeService {
    @Autowired
    HospedeRepository hospedeRepository;

    /**
     * <h1>Busca todos os {@link Hospede}s.</h1>
     *
     * <p>Busca todos os {@link Hospede}s
     * do banco através do {@link HospedeRepository#findAll()}.
     * Retorna um {@link ArrayList} de {@link Hospede}.</p>
     *
     * @return ArrayList {@link Hospede} - Referente aos
     * {@link Hospede}s encontrados
     *
     * @see Hospede
     * @see ArrayList
     * @see HospedeRepository#findAll()
     *
     * @author Lucas Nunes lucasnunes.ln365@gmail.com
     */
    public ArrayList<Hospede> buscarTodosOsHospedes(){
        return (ArrayList<Hospede>) hospedeRepository.findAll();
    }

    /**
     * <h1>Busca um {@link Hospede} pelo id.</h1>
     *
     * <p>Busca um {@link Hospede} no banco
     * pelo id informado através do
     * {@link HospedeRepository#findById(Object)}. 
     * Retorna o {@link Hospede} correspondente ao id.</p>
     *
     * @return {@link Hospede} - Referente ao {@link Hospede} encontrado
     *
     * @see Hospede
     * @see HospedeRepository#findById(Object)
     *
     * @author Lucas Nunes lucasnunes.ln365@gmail.com
     */
    public Hospede buscarHospedePeloId(Integer id){
        return hospedeRepository.findById(id).get();
    }

    /**
     * <h1>Insere um {@link Hospede}.</h1>
     *
     * <p>Recebe um {@link Hospede} e o
     * insere no banco através do 
     * {@link HospedeRepository#save(Object)}.
     * Retorna boolean true caso tenha
     * sido cadastrado.</p>
     *
     * @param hospede {@link Hospede} - Referente ao {@link Hospede}
     * informado
     *
     * @return boolean - true caso tenha sido cadastrado, false caso contrário
     *
     * @see Hospede
     * @see HospedeRepository#save(Object)
     */
    public boolean inserirHospede(Hospede hospede){
        try{
            hospedeRepository.save(hospede);
            return true;
        }catch(Exception e){
            System.err.println(e.getMessage());
            return false;
        }
    }

    /**
     * <h1>Deleta um {@link Hospede}.</h1>
     *
     * <p>Recebe um id e deleta o
     * {@link Hospede} referente ao id
     * informado através do
     * {@link HospedeRepository#deleteById(Object)}.
     * Retorna true caso tenha dado certo.</p>
     *
     * @param id Integer - Referente ao id informado
     *
     * @return boolean - true caso tenah deletado
     * o {@link Hospede}, false caso contrário
     *
     * @author Lucas Nunes lucasnunes.ln365@gmail.com
     * 
     * @see Hospede
     * @see HospedeRepository#deleteById(Object)
     */
    public boolean deletarHospedePeloId(Integer id){
        try{
            hospedeRepository.deleteById(id);
            return true;
        }catch (Exception e){
            System.out.println(e.getMessage());
            return false;
        }
    }

    /**
     * <h1>Atualiza um {@link Hospede}.</h1>
     *
     * <p>Recebe um id e um {@link Hospede}
     * e atualiza o {@link Hospede} com o
     * respectivo id através do
     * {@link HospedeRepository#save(Object)}.
     * Retorna true caso tenha dado certo.</p>
     *
     * @param id Integer - Referente ao id informado
     * @param hospede {@link Hospede} - Referene ao
     * {@link Hospede} informado
     *                               
     * @return boolean - true caso tenha sido atualizado,
     * false caso contrário
     * 
     * @see Hospede
     * @see HospedeRepository#save(Object) 
     */
    public boolean atualizaHospedePeloId(Integer id, Hospede hospede){
        try {
            hospede.setId(id);
            hospedeRepository.save(hospede);
            return true;
        }catch (Exception e){
            System.out.println(e.getMessage());
            return false;
        }
    }

    /**
     * <h1>Busca {@link Hospede}s que não
     * se encontram mais no hotel.</h1>
     *
     * <p>Recebe a data atual do sistema e procura
     * os {@link Hospede}s que tenham a data de saida
     * menor do que a data atual. Faz isso através
     * do {@link HospedeRepository#buscarHospedeQueJaRealizaramCheckIn(LocalDateTime)}.
     * Retorna boolean no final da operação.</p>
     *
     * @param dataAtual {@link LocalDateTime} - Referente a data
     *                                       atual do sistema
     *
     * @return boolean - true caso tudo tenha dado certo
     * false caso contrário
     *
     * @see Hospede
     * @see LocalDateTime
     * @see HospedeRepository#buscarHospedeQueJaRealizaramCheckIn(LocalDateTime)
     *
     * @author Lucas Nunes lucasnunes.ln365@gmail.com
     */
    public ArrayList<Hospede> buscarHospedeQueJaRealizaramCheckIn(LocalDateTime dataAtual){
        return (ArrayList<Hospede>) hospedeRepository.buscarHospedeQueJaRealizaramCheckIn(dataAtual);
    }

    /**
     * <h1>Busca {@link Hospede}s que ainda
     * se encontram no hotel.</h1>
     *
     * <p>Recebe a data atual do sistema e procura
     * os {@link Hospede}s que tenham a data de saida
     * maior do que a data atual. Faz isso através
     * do {@link HospedeRepository#buscarHospedeQueNaoRealizaramCheckIn(LocalDateTime)}.
     * Retorna boolean no final da operação.</p>
     *
     * @param dataAtual {@link LocalDateTime} - Referente a data
     *                                       atual do sistema
     *
     * @return boolean - true caso tudo tenha dado certo
     * false caso contrário
     *
     * @see Hospede
     * @see LocalDateTime
     * @see HospedeRepository#buscarHospedeQueNaoRealizaramCheckIn(LocalDateTime)
     *
     * @author Lucas Nunes lucasnunes.ln365@gmail.com
     */
    public ArrayList<Hospede> buscarHospedeQueNaoRealizaramCheckIn(LocalDateTime dataAtual){
        return (ArrayList<Hospede>) hospedeRepository.buscarHospedeQueNaoRealizaramCheckIn(dataAtual);
    }
}
