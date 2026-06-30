class Task {
    int taskId;
    String taskName;
    String status;
    Task next;

    Task(int taskId, String taskName, String status) {
        this.taskId = taskId;
        this.taskName = taskName;
        this.status = status;
        this.next = null;
    }
}

public class TaskManagementSystem {

    Task head = null;

    // Add Task
    void addTask(int id, String name, String status) {
        Task newTask = new Task(id, name, status);

        if (head == null) {
            head = newTask;
        } else {
            Task temp = head;
            while (temp.next != null) {
                temp = temp.next;
            }
            temp.next = newTask;
        }

        System.out.println("Task Added Successfully.");
    }

    // Search Task
    void searchTask(int id) {
        Task temp = head;

        while (temp != null) {
            if (temp.taskId == id) {
                System.out.println("Task Found:");
                System.out.println(temp.taskId + " | " + temp.taskName + " | " + temp.status);
                return;
            }
            temp = temp.next;
        }

        System.out.println("Task Not Found.");
    }

    // Traverse Tasks
    void traverseTasks() {
        Task temp = head;

        System.out.println("\nTask List:");

        while (temp != null) {
            System.out.println(temp.taskId + " | " + temp.taskName + " | " + temp.status);
            temp = temp.next;
        }
    }

    // Delete Task
    void deleteTask(int id) {

        if (head == null) {
            System.out.println("Task List is Empty.");
            return;
        }

        if (head.taskId == id) {
            head = head.next;
            System.out.println("Task Deleted Successfully.");
            return;
        }

        Task temp = head;

        while (temp.next != null && temp.next.taskId != id) {
            temp = temp.next;
        }

        if (temp.next == null) {
            System.out.println("Task Not Found.");
        } else {
            temp.next = temp.next.next;
            System.out.println("Task Deleted Successfully.");
        }
    }

    public static void main(String[] args) {

        TaskManagementSystem tms = new TaskManagementSystem();

        tms.addTask(101, "Design UI", "Pending");
        tms.addTask(102, "Develop Backend", "In Progress");
        tms.addTask(103, "Testing", "Pending");

        tms.traverseTasks();

        tms.searchTask(102);

        tms.deleteTask(101);

        tms.traverseTasks();
    }
}