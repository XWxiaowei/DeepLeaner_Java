package RPC;

public class SayHelloServiceImpl implements SayHelloService {

	@Override
	public String sayHello(String args) {
		// TODO Auto-generated method stub
		if(args.equals("hello")){
			return "hello";
		}
		else
		{
			return "bye bye";
		}
		
	}

}
