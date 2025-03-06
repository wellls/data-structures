/**
 * Diferente de linguagens como C, C++ e Java, onde arrays têm tamanho fixo,
 * no TypeScript (e JavaScript), os arrays são dinâmicos porque podem crescer e
 * diminuir automaticamente sem precisar alocar ou realocar memória manualmente.
 * Isso acontece porque os arrays no TypeScript são, na verdade, listas dinâmicas
 * implementadas internamente como objetos.
 *
 * Internamente, o JavaScript usa array dinâmicos baseados em objetos e otimiza
 * a alocação de memória para melhorar o desempenho. Inicialmente, o JavaScript
 * aloca uma certa quantidade de memória para o array. Se o array crescer além
 * da capacidade inicial, ele realoca um novo bloco maior de memória e copia os
 * elementos antigos para lá. Se removermos elementos, a memória pode ser
 * reutilizada, mas não necessariamente reduzida.
 *
 * Quando fazemos numbers.push(40), o motor:
 * Verifica se há espaço disponível na memória alocada.
 * Se houver espaço, adiciona o número sem realocação.
 * Se não houver espaço, cria um novo array maior, copia os elementos antigos
 * e adiciona o novo.
 *
 * Isso evita que cada inserção precise realocar memória, otimizando a performance.
 */
const numbers: number[] = [10, 20, 30, 40];

console.log(numbers[2]); // Saída: 30
numbers.pop(); // Remove o último elemento
numbers.push(50); // Adiciona um elemento no final
numbers.splice(1, 1); // Remove o segundo elemento (20)
console.log(numbers); // Saída: [10, 30, 50]
