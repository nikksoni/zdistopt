
public class EvenOdd implements Runnable{

	private Print printer;
	private static int value =0;

	public EvenOdd(Print print) {
		this.printer =print;
	}
	public Print getPrinter() {
		return printer;
	}

	public void setPrinter(Print printer) {
		this.printer = printer;
	}

	@Override
	public void run() {
		if(value%2==1){
			printOdd(value);
		} else{
			printEven(value);
		}
		
		
	}
	
	public void printOdd(int num){
		printer.printNum(num);
	}
	
	public void printEven(int num){
		printer.printNum(num);
	}
	
}
