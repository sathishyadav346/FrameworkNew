package genericLibraries;

public enum TabNames {

	ORGANIZATIONS("Organization"), LEADS("Leads"), CONTACTS("Contacts");

	private String tabName;

	private TabNames(String tab) {
		this.tabName = tab;
	}

	public String getTabName() {
		return tabName;
	}
}
