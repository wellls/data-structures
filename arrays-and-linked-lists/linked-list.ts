class ListNode {
  value: number;
  next: ListNode | null = null;

  constructor(value: number) {
    this.value = value;
  }
}

class LinkedList {
  head: ListNode | null = null;

  append(value: number): void {
    if (!this.head) {
      this.head = new ListNode(value);
      return;
    }

    let current = this.head;
    while (current.next) {
      current = current.next;
    }
    current.next = new ListNode(value);
  }

  print(): void {
    let current = this.head;
    while (current) {
      console.log(current.value);
      current = current.next;
    }
  }
}

// Exemplo de uso
const list = new LinkedList();
list.append(10);
list.append(20);
list.append(30);
list.print(); // Saída: 10, 20, 30
