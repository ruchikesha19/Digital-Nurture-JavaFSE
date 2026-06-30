class Order {
    int orderId;
    String customerName;
    double totalPrice;

    Order(int orderId, String customerName, double totalPrice) {
        this.orderId = orderId;
        this.customerName = customerName;
        this.totalPrice = totalPrice;
    }

    void display() {
        System.out.println(orderId + " | " + customerName + " | " + totalPrice);
    }
}

public class SortingCustomerOrders {

    // Bubble Sort
    static void bubbleSort(Order[] orders) {
        int n = orders.length;

        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (orders[j].totalPrice > orders[j + 1].totalPrice) {
                    Order temp = orders[j];
                    orders[j] = orders[j + 1];
                    orders[j + 1] = temp;
                }
            }
        }
    }

    // Quick Sort
    static void quickSort(Order[] orders, int low, int high) {
        if (low < high) {
            int pi = partition(orders, low, high);
            quickSort(orders, low, pi - 1);
            quickSort(orders, pi + 1, high);
        }
    }

    static int partition(Order[] orders, int low, int high) {
        double pivot = orders[high].totalPrice;
        int i = low - 1;

        for (int j = low; j < high; j++) {
            if (orders[j].totalPrice < pivot) {
                i++;
                Order temp = orders[i];
                orders[i] = orders[j];
                orders[j] = temp;
            }
        }

        Order temp = orders[i + 1];
        orders[i + 1] = orders[high];
        orders[high] = temp;

        return i + 1;
    }

    static void display(Order[] orders) {
        for (Order order : orders) {
            order.display();
        }
    }

    public static void main(String[] args) {

        Order[] orders = {
                new Order(101, "Alice", 3500),
                new Order(102, "Bob", 1200),
                new Order(103, "Charlie", 5000),
                new Order(104, "David", 2800)
        };

        System.out.println("Before Sorting:");
        display(orders);

        bubbleSort(orders);

        System.out.println("\nAfter Bubble Sort:");
        display(orders);

        Order[] orders2 = {
                new Order(101, "Alice", 3500),
                new Order(102, "Bob", 1200),
                new Order(103, "Charlie", 5000),
                new Order(104, "David", 2800)
        };

        quickSort(orders2, 0, orders2.length - 1);

        System.out.println("\nAfter Quick Sort:");
        display(orders2);
    }
}