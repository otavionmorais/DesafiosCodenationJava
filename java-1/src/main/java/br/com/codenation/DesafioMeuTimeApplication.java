package br.com.codenation;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import br.com.codenation.desafio.annotation.Desafio;
import br.com.codenation.desafio.app.MeuTimeInterface;
import br.com.codenation.desafio.exceptions.CapitaoNaoInformadoException;
import br.com.codenation.desafio.exceptions.IdentificadorUtilizadoException;
import br.com.codenation.desafio.exceptions.JogadorNaoEncontradoException;
import br.com.codenation.desafio.exceptions.TimeNaoEncontradoException;

public class DesafioMeuTimeApplication implements MeuTimeInterface {

	List<Time> times=new ArrayList<>();
	List<Jogador> jogadores=new ArrayList<>();


	public boolean existeTime(Long idTime){
		boolean existe=false;
		for (Time time : times) {
			if(time!=null && time.getId().equals(idTime)) {
				existe = true;
				break;
			}
		}
		return existe;
	}

	public Time getTime(Long idTime){

		if(!existeTime(idTime))
			throw new TimeNaoEncontradoException();

		for (Time time : times) {
			if (time.getId().equals(idTime))
				return time;
		}
		return null;
	}

	public Jogador getJogador(Long id){

		Jogador jogadorSelecionado=null;
		for (Jogador jogador : jogadores) {
			if(jogador!=null && jogador.getId().equals(id)){
				jogadorSelecionado=jogador;
				break;
			}
		}
		if(jogadorSelecionado==null)
			throw new JogadorNaoEncontradoException();

		return jogadorSelecionado;
	}

	@Desafio("incluirTime")
	public void incluirTime(Long id, String nome, LocalDate dataCriacao, String corUniformePrincipal, String corUniformeSecundario) {

		if(existeTime(id))
			throw new IdentificadorUtilizadoException();

		times.add(new Time(id, nome, dataCriacao,corUniformePrincipal, corUniformeSecundario));
	}

	@Desafio("incluirJogador")
	public void incluirJogador(Long id, Long idTime, String nome, LocalDate dataNascimento, Integer nivelHabilidade, BigDecimal salario) {

		jogadores.forEach(jogador -> {
			if(jogador!=null && jogador.getId().equals(id))
				throw new IdentificadorUtilizadoException();
		});

		Jogador novo = new Jogador(id, idTime, nome, dataNascimento, nivelHabilidade, salario);

		if(!existeTime(idTime))
			throw new TimeNaoEncontradoException();

		jogadores.add(novo);
		for (Time time : times) {
			if(time!=null && time.getId().equals(idTime)) {
				time.addJogador(novo);
				break;
			}
		}

	}

	@Desafio("definirCapitao")
	public void definirCapitao(Long idJogador) {

		Jogador jogadorSelecionado=null;
		for (Jogador jogador : jogadores) {
			if(jogador!=null && jogador.getId().equals(idJogador))
				jogadorSelecionado=jogador;
		}

		if(jogadorSelecionado==null)
			throw new JogadorNaoEncontradoException();

		Time timeDele=null;
		for (Time time : times) {
			if(time!=null && time.getJogadores().contains(jogadorSelecionado)){
				timeDele=time;
				break;
			}
		}

		for (Jogador jogador : timeDele.getJogadores()) {
			if(jogador!=null && jogador.isCapitao()){
				jogador.setCapitao(false);
				break;
			}
		}

		jogadorSelecionado.setCapitao(true);
	}

	@Desafio("buscarCapitaoDoTime")
	public Long buscarCapitaoDoTime(Long idTime) {

		Time timeSelecionado=null;
		for (Time time : times) {
			if(time!=null && time.getId().equals(idTime)) {
				timeSelecionado = time;
				break;
			}
		}
		if(timeSelecionado==null)
			throw new TimeNaoEncontradoException();

		Jogador capitao=null;
		for (Jogador jogador : timeSelecionado.getJogadores()) {

			if(jogador!=null && jogador.isCapitao()) {
				capitao = jogador;
			}
		}

		if(capitao==null)
			throw new CapitaoNaoInformadoException();

		return capitao.getId();
	}

	@Desafio("buscarNomeJogador")
	public String buscarNomeJogador(Long idJogador) {

		for (Jogador jogador : jogadores) {
			if(jogador!=null && jogador.getId().equals(idJogador))
				return jogador.getNome();
		}
		throw new JogadorNaoEncontradoException();
	}

	@Desafio("buscarNomeTime")
	public String buscarNomeTime(Long idTime) {
		if(!existeTime(idTime))
			throw new TimeNaoEncontradoException();

		for (Time time : times) {
			if(time!=null && time.getId().equals(idTime))
				return time.getNome();
		}
		return null;
	}

	@Desafio("buscarJogadoresDoTime")
	public List<Long> buscarJogadoresDoTime(Long idTime) {

		if(!existeTime(idTime))
			throw new TimeNaoEncontradoException();

		List<Long> idsJogadoresTime=new ArrayList<>();
		for (Jogador jogador : jogadores) {
			if(jogador!=null && jogador.getIdTime().equals(idTime))
				idsJogadoresTime.add(jogador.getId());
		}
		Collections.sort(idsJogadoresTime);
		return idsJogadoresTime;
	}

	@Desafio("buscarMelhorJogadorDoTime")
	public Long buscarMelhorJogadorDoTime(Long idTime) {

		if(!existeTime(idTime))
			throw new TimeNaoEncontradoException();

		List<Jogador> jogadoresTime=getTime(idTime).getJogadores();

		Jogador maior=jogadoresTime.get(0);
		for (Jogador jogador : jogadoresTime) {
			if(jogador.getHabilidade().compareTo(maior.getHabilidade())>0){
				maior=jogador;
			}
		}
		return maior.getId();
	}

	@Desafio("buscarJogadorMaisVelho")
	public Long buscarJogadorMaisVelho(Long idTime) {

		if(!existeTime(idTime))
			throw new TimeNaoEncontradoException();

		List<Jogador> jogadoresTime=getTime(idTime).getJogadores();

		Jogador maisVelho=jogadoresTime.get(0);
		for (Jogador jogador : jogadoresTime) {

			if(jogador.getIdade()>maisVelho.getIdade()){
				maisVelho=jogador;
			} else if(jogador.getIdade()==maisVelho.getIdade()){
				if(jogador.getId().compareTo(maisVelho.getId())<0)
					maisVelho=jogador;
			}
		}
		return maisVelho.getId();
	}

	@Desafio("buscarTimes")
	public List<Long> buscarTimes() {
		List<Long> resp=new ArrayList<>();

		for (Time time : times) {
			if(time!=null){
				resp.add(time.getId());
			}
		}
		Collections.sort(resp);
		return resp;

	}

	@Desafio("buscarJogadorMaiorSalario")
	public Long buscarJogadorMaiorSalario(Long idTime) {

		if(!existeTime(idTime))
			throw new TimeNaoEncontradoException();

		List<Jogador> jogadoresTime=getTime(idTime).getJogadores();

		Jogador maiorSalario=jogadoresTime.get(0);
		for (Jogador jogador : jogadoresTime) {

			if (jogador.getSalario().compareTo(maiorSalario.getSalario()) > 0){
				maiorSalario = jogador;

			} else if(jogador.getSalario().equals(maiorSalario.getSalario())){
				if(jogador.getId().compareTo(maiorSalario.getId())<0)
					maiorSalario=jogador;
			}
		}
		return maiorSalario.getId();
	}

	@Desafio("buscarSalarioDoJogador")
	public BigDecimal buscarSalarioDoJogador(Long idJogador) {
		return getJogador(idJogador).getSalario();
	}

	@Desafio("buscarTopJogadores")
	public List<Long> buscarTopJogadores(Integer top) {

		List<Jogador> ordenadosPorHabilidade = jogadores.stream()
				.sorted(Comparator.comparingInt(Jogador::getHabilidade).reversed())
				.collect(Collectors.toList());

		for(int i=1; i<ordenadosPorHabilidade.size(); i++){

			if(ordenadosPorHabilidade.get(i-1).equals(ordenadosPorHabilidade.get(i))&&
					ordenadosPorHabilidade.get(i-1).getId().compareTo(ordenadosPorHabilidade.get(i).getId())>0){
				Jogador temp=ordenadosPorHabilidade.get(i);
				ordenadosPorHabilidade.set(i, ordenadosPorHabilidade.get(i-1));
				ordenadosPorHabilidade.set(i-1, temp);
			}

		}

		List<Long> melhores=new ArrayList<>();
		for(int i=0; i<top.intValue(); i++){
			melhores.add(ordenadosPorHabilidade.get(i).getId());
		}

		if(ordenadosPorHabilidade==null || ordenadosPorHabilidade.size()==0)
			return new ArrayList<>();

		return melhores;
	}

	@Desafio("buscarCorCamisaTimeDeFora")
	public String buscarCorCamisaTimeDeFora(Long timeDaCasa, Long timeDeFora) {

		if(!existeTime(timeDaCasa) || !existeTime(timeDeFora))
			throw new TimeNaoEncontradoException();

		if(getTime(timeDaCasa).getCorUniformePrincipal().equals( getTime(timeDeFora).getCorUniformePrincipal() ))
			return getTime(timeDeFora).getCorUniformeSecundario();

		else
			return getTime(timeDeFora).getCorUniformePrincipal();
	}

}
