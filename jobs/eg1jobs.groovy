String repo="parthibanposhmark/hello-world"

dashboardView('example') {
    jobs {
        regex(/example1/)
    }
    columns {
        status()
        weather()
        lastSuccess()
        lastFailure()
        lastDuration()
        buildButton()
    }
    topPortlets {
        jenkinsJobsList {
			displayName('Jobs')
			}
	    }
	}

job("example1"){
	scm{
		github repo
	}
	triggers{
		scm 'H/10 * * * *'
	}
} 

job('example') {
    steps {
        copyArtifacts('example1') {
        		}
        	}
        }