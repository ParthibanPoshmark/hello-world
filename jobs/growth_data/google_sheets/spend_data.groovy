freeStyleJob('gdf-google_sheets/gd-google_sheets-spend_data') {
	description("<html>"+
  "<br/>"+
  "<br/>"+
  "<table>"+
    "<tr>"+
      "<td style='font-family: Consolas,monospace; '>"+
       "<b>Description	</b>"+	
      "</td>"+
      "<td style='font-family: Consolas,monospace;'>"+
        ": Pulls spend data from google sheets and updates the same in dw_acqusition_spend "+
      "</td>"+
   	"</tr>"+

    "<tr>"+
      "<td style='font-family: Consolas,monospace; '>"+
       "<b>Updates Table  </b>"+  
      "</td>"+
      "<td style='font-family: Consolas,monospace;'>"+
        ":  analytics.dw_acquisition_spend "+
      "</td>"+
    "</tr>"+

   	"<tr>"+
      "<td style='font-family: Consolas,monospace; '>"+
       "<b>Owner	</b>"+	
      "</td>"+
      "<td style='font-family: Consolas,monospace;'>"+
        ": 	aman@poshmark.com "+
      "</td>"+
   	"</tr>"+

   	"<tr>"+
      "<td style='font-family: Consolas,monospace; '>"+
       "<b>Rake File	</b>"+	
      "</td>"+
      "<td style='font-family: Consolas,monospace;'>"+
        ":	google_sheets/spend_data.rake "+
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

  logRotator(-1, 30, -1, -1)

  parameters{
    booleanParam('upload_to_s3', true, null)
    stringParam('worksheets', 'iheart', null)
  }

  weight(1)
  
  label('slave')

  disabled(true) //Its disabled

  scm{
     git{
      branch('*/master')
      remote{
        url('https://github.com/ParthibanPoshmark/hello-world')
      }
     }
  }

  authenticationToken('cytokinestorm')

  triggers{
    cron('H 8 * * *')
  }

  steps{
    shell('#!/bin/bash --login -x\n\nbash $WORKSPACE/docker_scripts/google_sheet/spend_data_pull.sh')
  }

}
