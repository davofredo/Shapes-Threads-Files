package threads;

public class MultithreadingOpenFiles implements Runnable {
    private String filePath;

    public MultithreadingOpenFiles(String filePath) {
        this.filePath = filePath;
    }

    @Override
    public void run() {
        openFile(filePath);
    }

    public void openFile(String filePath) {
        try {
            // TODO: This is not operating system agnostic.
            //Runtime.getRuntime().exec("open -a TextEdit " + filePath);
            Runtime.getRuntime().exec("notepad " + filePath);
        }catch (Exception e){
            System.out.println("No");
        }
    }
}
