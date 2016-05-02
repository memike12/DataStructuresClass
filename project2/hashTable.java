import java.util.LinkedList;
import java.util.Queue;


public class hashTable {
	private int size = 0;
	private int used = 0;
	private hashItem[] wordList = new hashItem[0];
	
	public hashTable(){
		wordList = new hashItem[10];
		this.size = 10;
	}
	
	//returns how many things are in the hash array
	public int howBig(){
		return this.used;
	}
	
	//makes a bigger array when this one fills up
	public hashTable(int biggerSize){
		wordList = new hashItem[biggerSize];
		this.size = biggerSize;
	}
	
	public void insert(String str){
		int index;
		float loadFactor = used/size;
		double noMoreThan = (3.0/4);
		
		//if my load factor exceeds 75% create a bigger hashTable
		if(loadFactor > noMoreThan){
			hashTable newWordList = new hashTable(size * 2);
			for(int x = 0; x < this.size; x++){
				if(wordList[x] != null){
					newWordList.insert(wordList[x].getWord());
					if(wordList[x].hasNext())
					{
						hashItem temp = wordList[x];				
						while(temp.hasNext()){
							newWordList.insert(temp.next.getWord());
							temp = temp.next;
						}
					}
				}
			}
			wordList = newWordList.wordList;
			this.size = newWordList.size;
			this.used = newWordList.used;
		}
		
		//finds the index and then saves the word in
		index = Math.abs(str.hashCode())%size;
		if((wordList[index]) == null){
			wordList[index] = new hashItem(str);
			used++;
		}
		//if something is in the index already copy it and make the new thing the first thing
		else {
			//see's if the word is already there
			if(wordList[index].word.equals(str)) return;
			
			//goes through all the chain to see if the word is there
			hashItem tempFinder = wordList[index];
			while(tempFinder.next != null){
				if(tempFinder.next.word.equals(str)) return;
				tempFinder= tempFinder.next;
			}
			//temp pointer to hold the stuff that was there
			hashItem temp = new hashItem();
			temp.word = wordList[index].word;
			temp.next = wordList[index].next;
			//the new first thing that is in that index location
			wordList[index] = new hashItem(str);
			wordList[index].next = temp;
			used++;
		}
	}
	
	public Boolean find(String word){
		//my(not really "mine" though) hash function
		int index = Math.abs(word.hashCode())%size;
		if(wordList[index] == null)
			return false;
		else if(wordList[index].word.equals(word))
			return true;
		else{
			hashItem temp = new hashItem();
			temp.word = wordList[index].word;
			temp.next = wordList[index].next;
			while(temp.next != null){
				if(temp.next.word.equals(word))
					return true;
				else temp = temp.next;
			}
		return false;
		}
	}
	
	public Queue<String> traverse(){
		Queue<String> q = new LinkedList<String>();
		for(int x = 0; x < size; x++){
			if(wordList[x] != null){
				q.add(wordList[x].word);
				hashItem temp = wordList[x];
				while(temp.next != null){
					q.add(temp.next.word);
					temp = temp.next;
				}
			}
		}
		return q;
	}
}
