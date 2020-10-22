import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Skyline {
	
	Building[] buildings;
	List<Integer> pointHeightForm;
	List<Integer> spikeForm;
	
	public Skyline(Building...buildings) {
		this.buildings = buildings;
		
		pointHeightForm = new ArrayList<Integer>();
		spikeForm = new ArrayList<Integer>();
	}
	
	public void createSkylineInduction() {
		
		int left;
		int height;
		int right;
		
		pointHeightForm.clear();
		spikeForm.clear();
		
		for(int x = 0; x < buildings.length; x++) {
			
			left = buildings[x].getLeft();
			height = buildings[x].getHeight();
			right = buildings[x].getRight();
			
			if (spikeForm.size() < right) {
				for(int y = spikeForm.size(); y < right; y++) {
					
					spikeForm.add(0);
				}
			}
			
			for (int y = left; y < right; y++) {
				
				if (height > spikeForm.get(y)) {
					spikeForm.set(y, height);
				}
				
			}
			
		}
		
		createPointHeight();
	}
	
	public void createSkylineDivideConquer() {
		
		pointHeightForm.clear();
		spikeForm.clear();
		
		int[] newSpikeForm = divideConquer(0, buildings.length);
		
		for(int height : newSpikeForm) {
			spikeForm.add(height);
		}
		
		createPointHeight();
	}
	
	private int[] divideConquer(int left, int right) {
		
		
		if(left < right) {
			
			int mid = (left + right) / 2;
			
			int[] leftSkyline = divideConquer(left, mid);
			int[] rightSkyline = divideConquer(mid+1, right);
			
			return combineSkylines(leftSkyline, rightSkyline);
		
		}
			
		if (left < buildings.length) {
			return buildings[left].getSpikeForm();
		}
		return buildings[left-1].getSpikeForm();
			
	}

	private int[] combineSkylines(int[] left, int[] right) {
		int[] greater;
		int[] lesser;
		
		if(left.length != right.length) {
			
			if(right.length > left.length) {
				
				greater = right;
				lesser = left;
				
			} else {
				greater = left;
				lesser = right;

			}
		} else {
			greater = left;
			lesser = left;
		}
		
		int[] combined = new int[greater.length];
		
		for(int x = 0; x < lesser.length; x++) {
			
			if(left[x] > right[x]) {
				combined[x] = left[x];
			} else {
				combined[x] = right[x];
			}
			
		}
		
		for(int x = lesser.length; x < combined.length; x++) {
			combined[x] = greater[x];
		}
		
		return combined;
		
	}
	
	private void createPointHeight() {
		
		//ensures pointHeightForm ArrayList is empty
		pointHeightForm.clear();
		
		//goes through the spike form array
		for (int x = 0; x < spikeForm.size(); x++) {
			
			
			if ((pointHeightForm.size() == 0) 
					&& (spikeForm.get(x) == 0)) {
				continue;
			}
			
			if((pointHeightForm.size() == 0) 
					|| (spikeForm.get(x) != spikeForm.get(x-1))) {
				
				pointHeightForm.add(x);
				pointHeightForm.add(spikeForm.get(x));
				
			}
			
			
		}
		
	}
	
	public void printSkyline() {
		int max = Collections.max(spikeForm);
		
		for(int x = max; x >= 0; x--) {
			
			for(int height : spikeForm) {
				
				if(height == x) {
					System.out.print("-");
				} else {
					System.out.print(" ");
				}
				
			}
			
			System.out.println("");
		}
		
		for(int x = 0; x < spikeForm.size(); x++) {
			
			if(x % 10 == 0) {
				System.out.print(x / 10);
			} else {
				System.out.print(" ");
			}
			
		}
		
	}
	
	public String toString() {
		
		StringBuffer phf = new StringBuffer("(");
		
		for(int x = 0; x < pointHeightForm.size(); x++) {
			
			if(x % 10 == 0 && x != 0) {
				phf.append("\n");
			}
			
			phf.append(pointHeightForm.get(x));
			phf.append(", ");
			
		}
		
		phf.delete(phf.length()-2, phf.length());
		phf.append(")");
		
		return phf.toString();
		
		
		
	}
	
}