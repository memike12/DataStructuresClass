
public class hashItem{
	public String word = null;
	public hashItem next = null;
	
	public hashItem(String str){
		this.word = str;
		this.next = null;
	}

	public hashItem(){}
	
	public String getWord() {
		return this.word;
	}
	
	public Boolean hasWord(){
		if(this.word == null)
			return false;
		else return true;
	}

	public boolean hasNext() {
		if(this.next == null)
			return false;
		else return true;
	}
	
}
