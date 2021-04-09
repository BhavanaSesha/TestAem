package com.mindtree.Project_O2Store.core.models;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.annotation.PostConstruct;

import org.apache.sling.api.resource.Resource;
import org.apache.sling.api.resource.ResourceResolver;
import org.apache.sling.models.annotations.Model;
import org.apache.sling.models.annotations.injectorspecific.SlingObject;

import com.day.cq.wcm.api.Page;
import com.day.cq.wcm.api.PageManager;

@Model(adaptables = Resource.class)
public class O2StoreHeaderModel {

	@SlingObject
	private Resource currentResource;
	@SlingObject
	private ResourceResolver resourceResolver;

	private List<Page> rootChildPages = new ArrayList<>();
	private List<Page> moreChildPages = new ArrayList<>();
	

	private Page rootPage;

	@PostConstruct
	protected void init() {

		PageManager pageManager = resourceResolver.adaptTo(PageManager.class);
		Page currentPage = pageManager.getContainingPage(currentResource);

		rootPage = currentPage.getAbsoluteParent(2);

		if (rootPage == null) {
			rootPage = currentPage;
		}

		

		Iterator<Page> rootChildList = rootPage.listChildren();
		while (rootChildList.hasNext()) {
			Page page = rootChildList.next();
			rootChildPages.add(page);
			Iterator<Page> childPages = page.listChildren();
			while(childPages.hasNext())
			{
				moreChildPages.add(childPages.next());
			}
		}
	}
	

	public Page getRootPage() {
		return rootPage;
	}

	public List<Page> getRootChildPages() {
		return rootChildPages;
	}

	public List<Page> getMoreChildPages() {
		return moreChildPages;
	}
	

}
