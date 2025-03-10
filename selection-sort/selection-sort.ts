function selectionSort(arr: number[]): number[] {
  let n = arr.length;

  for (let i = 0; i < n - 1; i++) {
    let minIndex = i;

    // Encontra o menor elemento no restante do array
    for (let j = i + 1; j < n; j++) {
      if (arr[j] < arr[minIndex]) {
        minIndex = j;
      }
    }

    // Troca o menor elemento encontrado com o primeiro elemento não ordenado
    if (minIndex !== i) {
      [arr[i], arr[minIndex]] = [arr[minIndex], arr[i]];
    }
  }

  return arr;
}

// Exemplo de uso
const numbers = [29, 10, 14, 37, 13];
console.log(selectionSort(numbers)); // Saída: [10, 13, 14, 29, 37]
