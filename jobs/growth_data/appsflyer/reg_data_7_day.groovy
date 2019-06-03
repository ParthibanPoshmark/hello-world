freeStyleJob('gdf-appsflyer/gd-appsflyer-reg_data-7_day') {
	description("<html>"+
  "<br/>"+
  "<br/>"+
  "<table>"+

    "<tr>"+
      "<td style='font-family: Consolas,monospace; '>"+
       "<b>Description	</b>"+	
      "</td>"+
      "<td style='font-family: Consolas,monospace;'>"+
        ": Pulls acq_channel, campaign and ad details etc from Appsflyer that were part of user registration for the last 7 days "+
      "</td>"+
   	"</tr>"+
    
    "<tr>"+
      "<td style='font-family: Consolas,monospace; '>"+
       "<b>Updates Table	</b>"+	
      "</td>"+
      "<td style='font-family: Consolas,monospace;'>"+
        ": 	analytics.dw_reg_attribution "+
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
        ":	appsflyer/reg_data.rake "+
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
    stringParam('start_date', null , 'YYYY-MM-DD')
    stringParam('end_date', null , 'YYYY-MM-DD')
    stringParam('days_back', '7', null)
    stringParam('event_types', 'reg_source,reg_attr', null)
    booleanParam('upload_to_s3', true, null)
    stringParam('media_source', null, 'Add One media source that you want to filter on. Leave blank otherwise')
  }

  weight(3)
  
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
    cron('H 2 * * *')
  }
  
  wrappers{
    timeout{
      elastic(300,5,180)
    }
  }

  steps{
    shell('bash $WORKSPACE/docker_scripts/reg_attributions/appsflyer_reg.sh')
  }

}