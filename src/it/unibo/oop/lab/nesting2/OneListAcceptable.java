package it.unibo.oop.lab.nesting2;

import java.util.Iterator;
import java.util.List;


public class OneListAcceptable <T> implements Acceptable<T>{
	
	private List <T> l;
	
	
	public OneListAcceptable(List<T> l) {
		this.l = l;
	}
	 class A implements Acceptor{
		Iterator<T> itr= OneListAcceptable.this.l.iterator();
		@Override
		public void accept(Object newElement) throws ElementNotAcceptedException {
			// TODO Auto-generated method stub
			if(itr.hasNext()) {
				T x = itr.next();
				if(!(x == newElement)) {
					throw new ElementNotAcceptedException(newElement);
				}
				
			}
			
			
		}

		@Override
		public void end() throws EndNotAcceptedException {
			// TODO Auto-generated method stub
			if(itr.hasNext() == true) throw new EndNotAcceptedException();
		}
		
	}
	@Override
	public Acceptor<T> acceptor() {
		// TODO Auto-generated method stub
		return new A();
	} 

}
