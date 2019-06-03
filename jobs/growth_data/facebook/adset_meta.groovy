freeStyleJob('gdf-facebook/gd-facebook-adset_meta') {
	description("<html>"+
  "<br/>"+
  "<br/>"+
  "<table>"+

    "<tr>"+
      "<td style='font-family: Consolas,monospace; '>"+
       "<b>Description	</b>"+	
      "</td>"+
      "<td style='font-family: Consolas,monospace;'>"+
        ": Pulls Adset meta data details from facebook "+
      "</td>"+
   	"</tr>"+
    
    "<tr>"+
      "<td style='font-family: Consolas,monospace; '>"+
       "<b>Updates Table	</b>"+	
      "</td>"+
      "<td style='font-family: Consolas,monospace;'>"+
        ": 	analytics.dw_growth_adset "+
      "</td>"+
   	"</tr>"+

   	"<tr>"+
      "<td style='font-family: Consolas,monospace; '>"+
       "<b>Owner	</b>"+	
      "</td>"+
      "<td style='font-family: Consolas,monospace;'>"+
        ": 	kamal@poshmark.com, parthiban@poshmark.com "+
      "</td>"+
   	"</tr>"+

   	"<tr>"+
      "<td style='font-family: Consolas,monospace; '>"+
       "<b>Rake File	</b>"+	
      "</td>"+
      "<td style='font-family: Consolas,monospace;'>"+
        ": facebook/adset_meta.rake "+
      "</td>"+
   	"</tr>"+

   	"<tr>"+
      "<td style='font-family: Consolas,monospace; '>"+
       "<b>Git	</b>"+	
      "</td>"+
      "<td style='font-family: Consolas,monospace;'>"+
        ": NA"+
      "</td>"+
   	"</tr>"+
    
    "<tr>"+
      "<td style='font-family: Consolas,monospace; '>"+
       "<b>JIRA	</b>"+	
      "</td>"+
      "<td style='font-family: Consolas,monospace;'>"+
        ": NA"+
      "</td>"+
   	"</tr>"+

  "</table>"+
"</html>")

  parameters{
    booleanParam('upload_to_s3', true, null)
    stringParam('account', null , null)
   }

  weight(1)
  
  label('slave')

  disabled(true)
  
  scm{
     git{
      branch('*/master')
      remote{
        url('https://github.com/ParthibanPoshmark/hello-world')
      }
     }
  }

  triggers{
    cron('H H/4 * * *')
  }

  wrappers{
    timeout{
      elastic(300,5,30)
    }
    buildUserVars()
  }

  steps{
      shell('#!/bin/bash --login -x\n\nbash $WORKSPACE/docker_scripts/facebook/import_adset_meta.sh')
  }

}