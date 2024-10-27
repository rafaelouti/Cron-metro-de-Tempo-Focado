# FocusTimer

**FocusTimer** é um aplicativo simples de cronômetro de foco criado em Java, que ajuda a gerenciar sessões de trabalho e descanso. Ele utiliza a técnica Pomodoro, mas com um diferencial: o tempo de trabalho e descanso é ajustado automaticamente conforme o usuário completa cada sessão, incentivando sessões de trabalho mais focadas ao longo do tempo.

## Funcionalidades

- **Cronômetro para sessões de trabalho e descanso**: Alterna automaticamente entre os tempos de foco e descanso.
- **Ajuste Dinâmico de Tempo**: Aumenta gradualmente o tempo de foco e reduz o tempo de descanso conforme o usuário mantém o ritmo.
- **Interface Simples**: Desenvolvido com Swing, possui um botão para iniciar e alternar sessões, além de uma exibição do tempo restante.

## Estrutura do Projeto

- `FocusTimer.java`: Arquivo principal contendo a lógica e a interface gráfica.
- Interface gráfica construída com Swing e `javax.swing.Timer`.

## Pré-requisitos

Para rodar este projeto, você precisa de:
- **Java 11** ou superior.
- **IntelliJ IDEA** ou qualquer outro IDE compatível com Java, ou a linha de comando.

## Como Executar

1. **Clone o repositório**:
   ```bash
   git clone https://github.com/seuusuario/focustimer.git
   cd focustimer
