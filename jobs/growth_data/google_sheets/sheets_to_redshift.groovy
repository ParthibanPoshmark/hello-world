freeStyleJob('gdf-google_sheets/gd-google_sheets-sheets_to_redshift') {
	description("<html>"+
  "<br/>"+
  "<br/>"+
  "<table>"+
    "<tr>"+
      "<td style='font-family: Consolas,monospace; '>"+
       "<b>Description	</b>"+	
      "</td>"+
      "<td style='font-family: Consolas,monospace;'>"+
        ": Creates a new table under google_sheets schema with the given sheet name then pulls data from the sheet and updates the same in the newly created table "+
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
        ":	google_sheets/sheets_to_redshift.rake "+
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
    stringParam('doc_key', null, null)
    stringParam('gid', null, null)
    stringParam('sheet_name', null, null)
    stringParam('slack_display_name', null, null)
    stringParam('hidden_columns', null, null)
    booleanParam('upload_to_s3', true, null)
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

  authenticationToken('cytokinestorm')

  steps{
    shell('#!/bin/bash --login -x\n\n. $WORKSPACE/docker_scripts/task_init.sh\nrun_docker "export doc_key=$doc_key && \\\nexport gid=$gid && \\\nexport hidden_columns=$hidden_columns && \\\nexport sheet_name=\"$sheet_name\" && \\\nexport slack_display_name=\\"$slack_display_name\\" && \\\nbundle exec rake google_sheets:sheets_to_redshift RAKE_ENV=docker_production --trace"')
  
  }

}
