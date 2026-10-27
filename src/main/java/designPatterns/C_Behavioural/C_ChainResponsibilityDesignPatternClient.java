package designPatterns.C_Behavioural;

// Priority Enum
enum Priority {
    BASIC, INTERMEDIATE, CRITICAL
}

// Request Class
class Request {
    private Priority priority;

    public Request(Priority priority) {
        this.priority = priority;
    }

    public Priority getPriority() {
        return priority;
    }
}

// Handler Interface
interface SupportHandler {
    void handleRequest(Request request);
    void setNextHandler(SupportHandler nextHandler);
}

// Concrete Handlers
class Level1SupportHandler implements SupportHandler {
    private SupportHandler nextHandler;

    public void setNextHandler(SupportHandler nextHandler) {
        this.nextHandler = nextHandler;
    }

    public void handleRequest(Request request) {
        System.out.println("Task " + (int)(Math.random()*10) + " is executing");
        if (request.getPriority() == Priority.BASIC) {
            System.out.println(this.getClass().getSimpleName() + " handled the request");
        } else if (nextHandler != null) {
            nextHandler.handleRequest(request);
        }
    }
}

class Level2SupportHandler implements SupportHandler {
    private SupportHandler nextHandler;

    public void setNextHandler(SupportHandler nextHandler) {
        this.nextHandler = nextHandler;
    }

    public void handleRequest(Request request) {
        System.out.println("Task " + (int)(Math.random()*10) + " is executing");
        if (request.getPriority() == Priority.INTERMEDIATE) {
            System.out.println(this.getClass().getSimpleName() + " handled the request");
        } else if (nextHandler != null) {
            nextHandler.handleRequest(request);
        }
    }
}

class Level3SupportHandler implements SupportHandler {
    public void handleRequest(Request request) {
        System.out.println("Task " + (int)(Math.random()*10) + " is executing");
        if (request.getPriority() == Priority.CRITICAL) {
            System.out.println(this.getClass().getSimpleName() + " handled the request");
        } else {
            System.out.println("Request cannot be handled.");
        }
    }

    public void setNextHandler(SupportHandler nextHandler) {
        // No next handler for Level 3
    }
}



public class C_ChainResponsibilityDesignPatternClient {

    public static void main(String[] args) {
        SupportHandler level1Handler = new Level1SupportHandler();
        SupportHandler level2Handler = new Level2SupportHandler();
        SupportHandler level3Handler = new Level3SupportHandler();

        level1Handler.setNextHandler(level2Handler);
        level2Handler.setNextHandler(level3Handler);

        Request request1 = new Request(Priority.BASIC);
        Request request2 = new Request(Priority.INTERMEDIATE);
        Request request3 = new Request(Priority.CRITICAL);

        level1Handler.handleRequest(request1);
        level1Handler.handleRequest(request2);
        level1Handler.handleRequest(request3);
    }
}
