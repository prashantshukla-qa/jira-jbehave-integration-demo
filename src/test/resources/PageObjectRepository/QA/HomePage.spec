Page Title: Publisher of streaming video, audio, and text library databases that promote research, teaching, and learning across disciplines, including music, counseling, history, business and more| Alexander Street

#Object Definitions
====================================================================================
lnk_navbar				xpath		//div[@class="navbar-nav-header"]//a[text()="${text}"]
lnk_menubar				xpath		//a[@id="nav-$" and contains(@href,'%')]
modal_requestTrial		xpath		//div[@aria-labelledby="myModalLabel"]
iframe_requestTrial		xpath		//div[@aria-labelledby="myModalLabel" and @style='display: block;']//iframe
inpt_requestTrial		xpath		//form[@id='pardot-form']//label[text()='${label}']/following-sibling::input
drpdwn_requestTrial		xpath		//form[@id='pardot-form']//label[text()='${label}']/following-sibling::select
btn_closeDialog			xpath		//div[contains(@style,'display: block;')]//button[contains(@class,'close')]
icn_search				xpath		//a[@id="search_icon"]
modal_search			xpath		//div[@aria-labelledby="global-search-modal"]
inpt_search				xpath		//div[@aria-labelledby="global-search-modal"]//input[@placeholder="Enter your keywords"]
inpt_radioSearchType	xpath		//label[@class="radio-inline" and contains(text(),'${option}')]/input
btn_search				xpath		//input[@type='submit' and @value='Search']
====================================================================================