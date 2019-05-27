freeStyleJob('gdf-tatari/gd-tatari-spot_booking') {
	description("<html>"+
  "<br/>"+
  "<br/>"+
  "<table>"+

    "<tr>"+
      "<td style='font-family: Consolas,monospace; '>"+
       "<b>Description	</b>"+	
      "</td>"+
      "<td style='font-family: Consolas,monospace;'>"+
        ": Fetches spot booking weekly data from tatari for the last 2 weeks "+
      "</td>"+
   	"</tr>"+
    
    "<tr>"+
      "<td style='font-family: Consolas,monospace; '>"+
       "<b>Updates Table	</b>"+	
      "</td>"+
      "<td style='font-family: Consolas,monospace;'>"+
        ": 	analytics.dw_tatari_spot_booking "+
      "</td>"+
   	"</tr>"+

   	"<tr>"+
      "<td style='font-family: Consolas,monospace; '>"+
       "<b>Owner	</b>"+	
      "</td>"+
      "<td style='font-family: Consolas,monospace;'>"+
        ": 	parthiban@poshmark.com "+
      "</td>"+
   	"</tr>"+

   	"<tr>"+
      "<td style='font-family: Consolas,monospace; '>"+
       "<b>Rake File	</b>"+	
      "</td>"+
      "<td style='font-family: Consolas,monospace;'>"+
        ":	tatari/spot_booking.rake"+
      "</td>"+
   	"</tr>"+

   	"<tr>"+
      "<td style='font-family: Consolas,monospace; '>"+
       "<b>Git	</b>"+	
      "</td>"+
      "<td style='font-family: Consolas,monospace;'>"+
        ": <a href='https://github.com/GoshPosh/automator/tree/GROWTH-326-TATARI_NEW_DATA_POINTS'>link</a>"+
      "</td>"+
   	"</tr>"+
    
    "<tr>"+
      "<td style='font-family: Consolas,monospace; '>"+
       "<b>JIRA	</b>"+	
      "</td>"+
      "<td style='font-family: Consolas,monospace;'>"+
        ": <a href='https://poshmark.atlassian.net/browse/GROWTH-326'>link</a>"+
      "</td>"+
   	"</tr>"+

  "</table>"+
"</html>")

  parameters{
    stringParam('start_week_date', null ,'YYYY-MM-DD')
    stringParam('end_week_date', null ,'YYYY-MM-DD')
    stringParam('weeks_back', '2', null)
    booleanParam('upload_to_s3', true, null)
  }

  weight(1)

  label('slave')
  
  scm{
     git{
      branch('*/master')
      remote{
        url('https://github.com/ParthibanPoshmark/hello-world')
      }
     }
  }

  triggers{
    cron('H H/12 * * * ')
  }

  wrappers{
    timeout{
      elastic(200,3,30)
    }
  }

  steps{
    shell('#!/bin/bash --login -x\n\nbash $WORKSPACE/docker_scripts/tatari/spot_booking.sh')
  }

}