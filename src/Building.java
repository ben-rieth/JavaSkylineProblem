
public class Building {
	
	private int left;
	private int height;
	private int right;
	
	private int[] spikeForm;
	
	public Building(int l, int h, int r) {
		this.left = l;
		this.height = h;
		this.right = r;
		
		this.spikeForm = createSpikeForm();
	}

	private int[] createSpikeForm() {
		
		int[] spikeFormTemp = new int[right];
		
		for(int x = left; x < right; x++) {
			spikeFormTemp[x] = height;
		}
		
		return spikeFormTemp;
		
	}
	
	public int getLeft() {
		return left;
	}

	public void setLeft(int left) {
		this.left = left;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}

	public int getRight() {
		return right;
	}

	public void setRight(int right) {
		this.right = right;
	}
	
	public static Building[] getTestSet() {
		
		Building[] testSet = new Building[8];
		
		testSet[0] = new Building(1, 11, 5);
		testSet[1] = new Building(2, 6, 7);
		testSet[2] = new Building(3, 13, 9);
		testSet[3] = new Building(12, 7, 16);
		testSet[4] = new Building(14, 3, 25);
		testSet[5] = new Building(19, 18, 22);
		testSet[6] = new Building(23, 13, 29);
		testSet[7] = new Building(24, 4, 28);
		
		return testSet;
		
	}

	/**
	 * @return the spikeForm
	 */
	public int[] getSpikeForm() {
		return spikeForm;
	}

	/**
	 * @param spikeForm the spikeForm to set
	 */
	public void setSpikeForm(int[] spikeForm) {
		this.spikeForm = spikeForm;
	}
	
}
