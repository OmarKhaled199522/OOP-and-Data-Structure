package eg.edu.alexu.csd.filestructure.avl;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class DictionaryImplementation implements IDictionary {

	private AVLTreeImplementation< String > avlImp = new
			AVLTreeImplementation< String >();
	
	@Override
	public void load(final File file) {
		
		BufferedReader br = null;
		
		try {
			
			br = new BufferedReader(new FileReader(file));
		
		} catch (FileNotFoundException e1) {
			
			System.out.println("Error");
		}
	 
		String line = null;
		
		try {
			
			while ((line = br.readLine()) != null) {
				insert(line);
			}
			
		} catch (IOException e) {}
	 
		try {
			
			br.close();
		} catch (IOException e) {}
	}

	@Override
	public boolean insert(String word) {
		
		if(avlImp.getAvlValues().containsKey(word) != true){
			
			avlImp.insert(word);
			return true;
		}
		System.out.println("Error! already exist!");
		return false;
	}

	@Override
	public boolean exists(String word) {
	
		return avlImp.search(word);
	}

	@Override
	public boolean delete(String word) {
		
		return avlImp.delete(word);
	}

	@Override
	public int size() {
		
		return avlImp.getSize();
	}

	@Override
	public int height() {
		
		return avlImp.getRootHeight();
	}

}
