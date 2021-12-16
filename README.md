# MC426 - Develop Branch

## Repositorio do Projeto de MC426 - Engenharia de Software
## Tema: Solução de Saúde Pública -> Software de Gestão Hospitalar
* Software para gestão de recursos de um hospital e outras funcionalidades como acompanhar estado de pacientes, observar horários de consultar e exames, armazenar dados sobre tratamentos, controle de vagas e outros.

<details>
    <summary><h3>Integrantes do grupo:</h3></summary>

    -   RA 193400 - Alan Freitas Ribeiro
    -   RA 195620 - Cauan Newton Alves Souza
    -   RA 201270 - Leonardo Rener De Oliveira
    -   RA 203304 - Mateus Rangel Teixeira Diniz
    -   RA 241997 - Melanie Nellen Soares
</details>
<details>
    <summary><h3>Diagrama</h3></summary>
    ![Diagrama](https://gitlab.com/Necctares/mc426/-/raw/fd96c8c09ff52089f86eb35d889fc4e0380c00a6/misc/diagrama.jpg)
</details>
<details>
    <summary><h3>Estilos e Componentes</h3></summary>
        <h1>Estilos Arquiteturais</h1>
        <details>
        <summary><h2>Model-View-Controller</h2></summary>
        <p>Para interagir com o software, o usuário utiliza o sistema do aplicativo no computador que está estruturado no modelo MVC. Uma Interface Gráfica envia as ações do usuário para um Controlador, que por sua vez pede dados para um Modelo de Requisições. A descrição de cada um desses componentes pode ser vista abaixo.</p>
        <p><strong>Componentes envolvidos:</strong></p>
        <p><strong>Interface Gráfica</strong></p>
	    <p>Interface que possibilita a interação entre o usuário e o software por meio da manipulação das partes gráficas por parte do usuário. Recebe as ações do usuário e apresenta o estado visual do aplicativo.</p>
        <p><strong>Controlador do Aplicativo</strong></p>
	    <p>Recebe as ações tomadas pelo usuário, decide quais dados pedir ao modelo e informa o que a interface gráfica deve apresentar.</p>
        <p><strong>Modelo de Requisições</strong></p>
	    <p>Componente que intermedia dados para o aplicativo. Além de solicitar os dados, também notifica o controlador sobre quaisquer alterações nestes.</p>
        </details>
        <details>
        <summary><h2>Pipes and Filters</h2></summary>
        <p>Para generalizar as funções da aplicação, temos uma API separada que pode ser implementada em outras plataformas além do computador. Essa API oferece métodos para retornar dados salvos no Banco de Dados. O processamento desses dados segue uma cadeia baseada no padrão Pipes and Filters. Os componentes que implementam isso são descritos a seguir.</p>
        <p><strong>Componentes envolvidos:</strong></p>
        <p><strong>Controlador Geral</strong></p>
	    <p>Recebe requisições do sistema que atualmente interage com o usuário. Baseado no que é pedido, o controlador geral decide qual controlador usar para receber os dados pertinentes. É implementado usando o padrão de código de Fachada.</p>
        <p><strong>Controlador de Prontuário do Paciente</strong></p>
        <p>Interage com o banco para editar ou visualizar o prontuário de qualquer paciente.</p>
        <p><strong>Controlador de Horários do Médico</strong></p>
        <p>Interage com o banco para mudar ou conferir os horários disponíveis para atendimento da equipe médica do hospital.</p>
        <p><strong>Controlador de Confirmação de Consultas</strong></p>
        <p>Interage com o banco para atualizar ou consultar o estado de confirmação das consultas, onde médicos ou usuários podem confirmar presença ou ausência.</p>
        <p><strong>Fachada do Banco de Dados</strong><p>
        <p>Serve de fachada para facilitar a comunicação com o Sistema do Banco de Dados. Recebe chamadas de métodos dos controladores acima e, com base nisso, lê ou edita dados no Banco de Dados.</p>
        </details>
</details>
