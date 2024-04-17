package tech.ada.queroserdev.service;

import org.springframework.stereotype.Service;
//Importa a anotação Service do Spring Framework, que é usada para marcar esta classe como um componente de serviço.
import tech.ada.queroserdev.domain.dto.exception.NotFoundException;
import tech.ada.queroserdev.domain.dto.v1.ProfessorDto;

import java.util.ArrayList;
//Importa a classe ArrayList do pacote java.util, que implementa a interface List
// e é usada para armazenar uma lista de objetos em memória.
import java.util.List;
import java.util.NoSuchElementException;
//Importa a exceção NoSuchElementException do pacote java.util, que é lançada para indicar que uma operação de acesso
// a um elemento falhou devido a um elemento não existir.

@Service //Anotação Spring que marca a classe ProfessorService como um componente de serviço.

public class ProfessorService implements IProfessorService {
//Define a declaração da classe ProfessorService, que implementa a interface IProfessorService.
// Essa classe é responsável pela implementação dos métodos definidos na interface.
    private final List<ProfessorDto> professores = new ArrayList<>();
    // Declaração de um campo final professores que armazena a lista de professores.
    // Inicializado como uma nova instância de ArrayList.
    private int id = 1;
    // Declaração de um campo id inicializado como 1. Esse campo será usado para atribuir IDs únicos aos professores.

    @Override //Indica que os métodos subsequentes estão substituindo os métodos da interface IProfessorService.

    public ProfessorDto criarProfessor(ProfessorDto novoProfessor) {
        //Implementação do método criarProfessor da interface IProfessorService. Este método cria um novo professor
        // com base no objeto ProfessorDto fornecido, atribui um ID único e o adiciona à lista de professores.
        final ProfessorDto p = new ProfessorDto(
                id++,
                novoProfessor.getNome(),
                novoProfessor.getCpf(),
                novoProfessor.getEmail(),
                null
        ); //Cria um novo objeto ProfessorDto com um ID único, usando o valor de id
        // e incrementando-o para o próximo professor.
        professores.add(p); // Adiciona o novo professor à lista de professores.
        return p; // Retorna o novo professor criado.
    }

    @Override
    public List<ProfessorDto> listarProfessores() {
        return professores;
    } //Este método retorna uma lista de todos os professores armazenados na variável professores,
    // que é uma lista definida na classe ProfessorService.
    //Ele simplesmente retorna a lista de professores sem realizar qualquer modificação ou filtragem.

    @Override
    public ProfessorDto buscarProfessor(int id) throws NotFoundException {
        return professores
                .stream()
                .filter(it -> it.getId()==id)
                .findFirst()
                .orElseThrow(() -> new NotFoundException(ProfessorDto.class, String.valueOf(id)));
    } //Este método busca um professor pelo seu ID na lista de professores (professores). Ele usa o método stream()
    // para converter a lista em um fluxo de elementos. O método filter() é usado para filtrar os elementos do fluxo
    // com base em uma condição. Neste caso, ele filtra os professores cujo ID seja igual ao ID fornecido como argumento.
    // findFirst() é usado para encontrar o primeiro elemento que atende ao critério de filtragem.Se o professor
    // for encontrado, ele é retornado. Caso contrário, é lançada uma exceção NotFoundException com uma mensagem
    // indicando que o professor com o ID fornecido não foi encontrado.

    @Override
    public ProfessorDto atualizarProfessor(int id, ProfessorDto pedido) {
        final ProfessorDto professor = professores.stream().filter(it -> it.getId() == id).findFirst().orElse(null);
        if (professor == null) {
            return null;
        }
        professores.remove(professor);

        final ProfessorDto p = new ProfessorDto(professor.getId(), pedido.getNome(), pedido.getCpf(), pedido.getEmail(), null);
        professores.add(p);
        return p;
    } //Este método atualiza um professor existente com base no ID fornecido e nos dados fornecidos no objeto pedido.
    // Primeiro, ele procura pelo professor na lista de professores com o ID fornecido. Se o professor não for
    // encontrado, ele retorna null. Se o professor for encontrado, ele é removido da lista de professores. Um novo
    // objeto ProfessorDto é criado com os dados fornecidos no objeto pedido e o ID do professor encontrado.
    // O novo professor é adicionado à lista de professores e retornado como resultado da operação.

    @Override
    public void removerProfessor(int id) throws NotFoundException {
        final ProfessorDto professor = buscarProfessor(id);
        professores.remove(professor);
    } //Este método remove um professor da lista de professores com base no ID fornecido. Ele utiliza o método
    // buscarProfessor(id) para encontrar o professor com o ID fornecido. Se o professor não for encontrado,
    // uma exceção NotFoundException é lançada. Se o professor for encontrado, ele é removido da lista de professores.

    @Override
    public ProfessorDto buscarPorCpf(String cpf) throws NotFoundException {
        return null;
    }
}




