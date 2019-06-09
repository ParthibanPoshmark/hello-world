multiJob('gdf-facebook/gd-facebook-ad_spend-multi_job_sync') {
	description("<html>"+
  "<br/>"+
  "<br/>"+
  "<table>"+

    "<tr>"+
      "<td style='font-family: Consolas,monospace; '>"+
       "<b>Description	</b>"+	
      "</td>"+
      "<td style='font-family: Consolas,monospace;'>"+
        ": Multi job which triggers all facebook spend tasks "+
      "</td>"+
   	"</tr>"+
    
    "<tr>"+
      "<td style='font-family: Consolas,monospace; '>"+
       "<b>Updates Table	</b>"+	
      "</td>"+
      "<td style='font-family: Consolas,monospace;'>"+
        ": 	analytics.dw_acquisition_spend "+
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
        ": facebook/ad_spend.rake "+
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

  weight(1)

  concurrentBuild()
  
  label('master')

  disabled(true)

  steps{
    phase('1'){
      phaseJob('gdf-facebook/gd-facebook-ad_spend-102257116603016_sync'){
      killPhaseCondition('NEVER')
      currentJobParameters(true)
      }
      phaseJob('gdf-facebook/gd-facebook-ad_spend-1311786048838263_sync'){
      killPhaseCondition('NEVER')
      currentJobParameters(true)
      }
       phaseJob('gdf-facebook/gd-facebook-ad_spend-1334602183223316_sync'){
      killPhaseCondition('NEVER')
      currentJobParameters(true)
      }
       phaseJob('gdf-facebook/gd-facebook-ad_spend-1368443379839196_sync'){
      killPhaseCondition('NEVER')
      currentJobParameters(true)
      }
       phaseJob('gdf-facebook/gd-facebook-ad_spend-141632906_sync'){
      killPhaseCondition('NEVER')
      currentJobParameters(true)
      }
       phaseJob('gdf-facebook/gd-facebook-ad_spend-1551884058161793_sync'){
      killPhaseCondition('NEVER')
      currentJobParameters(true)
      }
       phaseJob('gdf-facebook/gd-facebook-ad_spend-1368442333172634_sync'){
      killPhaseCondition('FAILURE')
      currentJobParameters(true)
      abortAllJobs(true)
      }
       phaseJob('gdf-facebook/gd-facebook-ad_spend-1318540404829494_sync'){
      killPhaseCondition('FAILURE')
      currentJobParameters(true)
      abortAllJobs(true)
      }
      phaseJob('gdf-facebook/gd-facebook-ad_spend-251434835063079_sync'){
      killPhaseCondition('FAILURE')
      currentJobParameters(true)
      abortAllJobs(true)
      }
      phaseJob('gdf-facebook/gd-facebook-ad_spend-1994247617556775_sync'){
      killPhaseCondition('FAILURE')
      currentJobParameters(true)
      abortAllJobs(true)
      }
      phaseJob('gdf-facebook/gd-facebook-ad_spend-770511926480165_sync'){
      killPhaseCondition('FAILURE')
      currentJobParameters(true)
      abortAllJobs(true)
      }
      phaseJob('gdf-facebook/gd-facebook-ad_spend-1382302458648953_sync'){
      killPhaseCondition('FAILURE')
      currentJobParameters(true)
      abortAllJobs(true)
      }
      executionType('PARALLEL')
      continuationCondition('ALWAYS')
    }
    phase('2'){
      phaseJob('gdf-facebook/gd-facebook-fb_tube_monthly_spend-sync'){
      killPhaseCondition('FAILURE')
      currentJobParameters(true)
      abortAllJobs(true)
      }
      executionType('PARALLEL')
      continuationCondition('ALWAYS')
    }
  }

  publishers {
      mailer('data-eng@poshmark.com', false, false)
    }

}