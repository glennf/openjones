package jones.possessions;

public class Commodity {
	
	protected int _unitValue;
	protected String _name;
	
	public Commodity (int value, String name) {
		_unitValue = value;
		_name = name;
	}

	public int getUnitValue() {
		return _unitValue;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((_name == null) ? 0 : _name.hashCode());
		//result = prime * result + _unitValue;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Commodity other = (Commodity) obj;
		if (_name == null) {
			if (other._name != null)
				return false;
		} else if (!_name.equals(other._name))
			return false;
//		if (_unitValue != other._unitValue)
//			return false;
		return true;
	}
	

    

}