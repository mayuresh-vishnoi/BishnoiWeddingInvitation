<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Bishnoi Wedding Invitation</title>
    <link href="https://fonts.googleapis.com" rel="stylesheet">
    <style>
        :root {
            --primary-gold: #D4AF37;
            --deep-maroon: #800000;
            --bg-cream: #FFFDD0;
        }

        body {
            margin: 0;
            background-color: #2c2c2c;
            display: flex;
            justify-content: center;
            align-items: center;
            min-height: 100vh;
            font-family: 'Poppins', sans-serif;
        }

        .card {
            width: 90%;
            max-width: 500px;
            background-color: var(--bg-cream);
            border: 12px solid var(--deep-maroon);
            outline: 4px solid var(--primary-gold);
            padding: 40px 20px;
            text-align: center;
            box-shadow: 0 10px 30px rgba(0,0,0,0.5);
        }

        h3.mantra {
            font-family: 'Cinzel', serif;
            color: var(--deep-maroon);
            letter-spacing: 1px;
        }

        .names {
            font-family: 'Great Vibes', cursive;
            font-size: 3rem;
            color: var(--deep-maroon);
            margin: 20px 0;
        }

        .bishnoi-motto { color: green; font-weight: bold; font-size: 0.9rem; }
    </style>
</head>
<body>
<form id="weddingForm" method="POST">
    <div class="card">
        <h3 class="mantra">|| ॐ श्री गुरु जम्भेश्वराय नम: ||</h3>
        <p class="bishnoi-motto">जीव दया पालणी, रूंख लीलो नी घावणी</p>

        <p>We cordially invite you to the wedding of</p>

        <div class="names">
                    <label>Template ID:</label>
                    <input type="number" id="tempIdInput" value="1" required>
                    <%-- Change 2: Add 'name' attributes so Spring can find them --%>
                    <input type="text" name="groomName" placeholder="Groom Name" required>
                    <br> & <br>
                    <input type="text" name="brideName" placeholder="Bride Name" required>
                    <br>
                    <button type="submit" onclick="submitInvitation()">Generate Invitation</button>
                </div>

        <div style="border-top: 1px solid var(--primary-gold); padding-top: 10px; color: var(--deep-maroon);">
            SATURDAY | 22nd NOVEMBER | 2025
        </div>
    </div>
</form>
<script>
function submitInvitation() {
    var id = document.getElementById('tempIdInput').value;
    var form = document.getElementById('weddingForm');

    // 3. Set the correct path that matches your @PostMapping
    form.action = "/invitation/create/" + id;

    // 4. Manually trigger the submit
    form.submit();
}
</script>
</body>
</html>