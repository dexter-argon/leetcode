import java.util.*;

class LC3408 {

    class TaskManager {

        class Task implements Comparable<Task> {
            int userId;
            int taskId;
            int priority;

            public Task(int userId, int taskId, int priority) {
                this.userId = userId;
                this.taskId = taskId;
                this.priority = priority;
            }
            
            public Task(Task task) {
                this.userId = task.userId;
                this.taskId = task.taskId;
                this.priority = task.priority;
            }

            @Override
            public int compareTo(Task other) {
                if (this.priority == other.priority) {
                    return other.taskId - this.taskId ; // if equal prioritize higher taskId
                }
                return other.priority - this.priority; 
            }
        }

        // Member variables
        private PriorityQueue<Task> taskPriorityQueue =  new PriorityQueue<>();
        private Map<Integer, Integer> taskPriority = new HashMap<>();
        private Map<Integer, Integer> taskUserMap = new HashMap<>();


        // task has [userId, taskId, priority]
        @SuppressWarnings("OverridableMethodCallInConstructor")
        public TaskManager(List<List<Integer>> tasks) {

            for (var task: tasks) {
                int userId = task.get(0);
                int taskId = task.get(1);
                int priority = task.get(2);

                add(userId, taskId, priority);
            }

        }

        public void add(int userId, int taskId, int priority) {
            var taskObj = new Task(userId, taskId, priority);
            taskPriorityQueue.add(taskObj);
            taskPriority.put(taskId, priority);
            taskUserMap.put(taskId, userId);
        }

        public void edit(int taskId, int newPriority) {
            add(taskUserMap.get(taskId), taskId, newPriority);
        }

        public void rmv(int taskId) {
            taskPriority.put(taskId, -1);
        }

        public int execTop() {
            while (!taskPriorityQueue.isEmpty()) {
                Task task = taskPriorityQueue.poll();
                Integer currentPriority = taskPriority.get(task.taskId);
                Integer userId = taskUserMap.get(task.taskId);
                
                if (currentPriority != null && currentPriority != -1 
				&& task.priority == currentPriority && userId == task.userId) {

                    taskPriority.remove(task.taskId);
                    taskUserMap.remove(task.taskId);
                    return task.userId;
                }
            }
            return -1;
        }
    }
}