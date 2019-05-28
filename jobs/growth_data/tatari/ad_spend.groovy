freeStyleJob('gdf-tatari/gd-tatari-ad_spend') {
	description("<html>"+
  "<br/>"+
  "<br/>"+
  "<table>"+

    "<tr>"+
      "<td style='font-family: Consolas,monospace; '>"+
       "<b>Description	</b>"+	
      "</td>"+
      "<td style='font-family: Consolas,monospace;'>"+
        ": Fetches spend data, campaign and ad metadata from tatari for the last 10 days "+
      "</td>"+
   	"</tr>"+
    
    "<tr>"+
      "<td style='font-family: Consolas,monospace; '>"+
       "<b>Updates Table	</b>"+	
      "</td>"+
      "<td style='font-family: Consolas,monospace;'>"+
        ": 	analytics.dw_tatari_spend, analytics.dw_growth_campaign, analytics.dw_growth_ad, analytics.dw_acquisition_spend "+
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
        ":	tatari/ad_spend.rake"+
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

  blockOn('.*dw_acquisition_spend.*'){
    blockLevel('GLOBAL')
    scanQueueFor('ALL')
  }

  parameters{
    stringParam('start_date', null ,'YYYY-MM-DD')
    stringParam('end_date', null ,'YYYY-MM-DD')
    stringParam('days_back', '10', null)
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

  triggers{
    cron('H 6,7,8,9,10,14,18,22,4 * * * ')
  }

  wrappers{
    timeout{
      elastic(200,3,30)
    }
  }

  steps{
    shell('#!/bin/bash --login -x\n\nbash $WORKSPACE/docker_scripts/tatari/ingest_data.sh')
  }

}