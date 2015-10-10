package phillips.deliverable2.code;

public class Road
{
	private String _src;
	private String _name;
	private String _dest;
	
	public Road(String src, String name, String dest)
	{
		if (src == null || name == null || dest == null)
		{
			throw new IllegalArgumentException("Parameters can't be null");
		}
		this._src = src;
		this._name = name;
		this._dest = dest;
	}
	
	public String getSource()
	{
		return _src;
	}
	
	public String getName()
	{
		return _name;
	}
	
	public String getDest()
	{
		return _dest;
	}
	
	@Override
	public int hashCode()
	{
		return _src.hashCode() ^ _name.hashCode() ^ _dest.hashCode();
	}
	
	/*
	 * Two roads are equal if they have equivalent sources, names, and destinations
	 */
	@Override
	public boolean equals(Object obj)
	{
		if (obj == null || !(obj instanceof Road))
		{
			return false;
		}
		
		Road other = (Road)obj;
		
		return other._src.equals(_src) && other._name.equals(_name) && other._dest.equals(_dest);
	}
	
	@Override
	public String toString()
	{
		return String.format("%s to %s via %s", _src, _dest, _name);
	}
}
