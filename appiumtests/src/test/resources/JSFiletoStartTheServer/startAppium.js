const { exec } = require('child_process');

function startAppium() {
  // Command to start Appium server
  const appiumCommand = 'appium';

  // Start Appium server
  const server = exec(appiumCommand, (error, stdout, stderr) => {
    if (error) {
      console.error(`Error starting Appium server: ${error}`);
      return;
    }

    if (stderr) {
      console.error(`Appium stderr: ${stderr}`);
      return;
    }

    console.log(`Appium stdout: ${stdout}`);
  });

  // Log server output
  server.stdout.on('data', (data) => {
    console.log(`Appium server output: ${data}`);
  });

  server.stderr.on('data', (data) => {
    console.error(`Appium server error: ${data}`);
  });

  return server;
}

// Start the server
const server = startAppium();

// Optionally, stop the server after some time or based on some condition
setTimeout(() => {
  server.kill(); // Stop the server
  console.log('Appium server stopped');
}, 60000); // Example: Stop after 60 seconds