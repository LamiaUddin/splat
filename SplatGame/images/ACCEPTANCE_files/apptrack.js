$("<button class='docs'>Display<\/button>").insertBefore($("div.docwrap"));var towrap="<div class='docs' style='display:none;margin-left:20px;'><\/div>";$("div.docwrap").wrap(towrap);$("button.docs").click(function(){$(this).next().animate({opacity:"toggle"});$(this).html()=="Display"?$(this).text("Minimize"):$(this).text("Display")});